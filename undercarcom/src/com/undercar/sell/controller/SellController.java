package com.undercar.sell.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.undercar.attachment.dto.AttachmentDTO;
import com.undercar.caroption.dto.CarOptionDTO;
import com.undercar.category.dto.CategoryDTO;
import com.undercar.main.Controller;
import com.undercar.main.Execute;
import com.undercar.main.Service;
import com.undercar.sell.dto.SellDTO;
import com.undercar.util.io.FileUtil;
import com.undercar.util.page.PageObject;
import com.webjjang.util.ImageResizing;

public class SellController implements Controller{

	private Service sellListService;
	private Service carBrandListService;
	private Service carClassListService;
	private Service kModelListService;
	private Service hModelListService;
	private Service sModelListService;
	private Service ssModelListService;
	private Service gmModelListService;
	
	private Service sellWriteService;
	private Service attachmentWriteService;
	private Service caroptionWriteService;
	private Service sellViewService;
	private Service categoryWriteService;
	
	private Service sellDeleteService;
	private Service sellSchListService;
	private Service attachmentDeleteService;
	private Service categoryDeleteService;
	private Service caroptionDeleteService;

	private Service sellUpdateService;
	private Service sellOptionUpdateService;
	private Service sellCategoryUpdateService;
	private Service sellFileUpdateService;
	
	private Service sellcompleteService;
	
	public SellController(Service sellListService, Service carBrandListService, Service carClassListService, Service kModelListService, 
			Service hModelListService, Service sModelListService, Service ssModelListService, Service gmModelListService, Service sellWriteService,
			Service attachmentWriteService, Service caroptionWriteService, Service sellViewService,
			Service categoryWriteService, Service sellDeleteService, Service sellSchListService,Service attachmentDeleteService, 
			Service categoryDeleteService,Service caroptionDeleteService, Service sellUpdateService, Service sellOptionUpdateService, Service sellCategoryUpdateService, Service sellFileUpdateService,
			Service sellcompleteService) {
		
		this.sellListService = sellListService;
		this.carBrandListService = carBrandListService;
		this.carClassListService = carClassListService;
		this.kModelListService = kModelListService;
		this.hModelListService = hModelListService;
		this.sModelListService = sModelListService;
		this.ssModelListService = ssModelListService;
		this.gmModelListService = gmModelListService;
		
		this.sellWriteService = sellWriteService;
		this.attachmentWriteService = attachmentWriteService;
		this.caroptionWriteService = caroptionWriteService;
		this.sellViewService = sellViewService;
		this.categoryWriteService = categoryWriteService;
		
		this.sellDeleteService = sellDeleteService;
		this.sellSchListService = sellSchListService;
		this.attachmentDeleteService = attachmentDeleteService;
		this.categoryDeleteService = categoryDeleteService;
		this.caroptionDeleteService = caroptionDeleteService;
		
		this.sellUpdateService = sellUpdateService;
		this.sellOptionUpdateService = sellOptionUpdateService;
		this.sellCategoryUpdateService = sellCategoryUpdateService;
		this.sellFileUpdateService = sellFileUpdateService;
		
		this.sellcompleteService = sellcompleteService;
		
	}
		
	int size = 100*1024*1024;
	
	String path = "/upload/sellImage/";
	
	String noStr="";
	
	String sell_NoStr = "";
	
	String perPageNumStr = "";
	
//	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		
		String jsp ="";
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"), 
				request.getParameter("strPerPageNum"));
		
		// 검색
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		if(word != null) {
			pageObject.setKey(key);
			pageObject.setWord(word);
		}// end of if
		
		switch(uri) {
		case "/sell/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(sellListService, pageObject));
			request.setAttribute("carBrandList", Execute.service(carBrandListService));
			request.setAttribute("carClassList", Execute.service(carClassListService));
			request.setAttribute("modelList", Execute.service(kModelListService));
			request.setAttribute("modelList", Execute.service(hModelListService));
			request.setAttribute("modelList", Execute.service(sModelListService));
			request.setAttribute("modelList", Execute.service(ssModelListService));
			request.setAttribute("modelList", Execute.service(gmModelListService));
//			request.setAttribute("categoryList", Execute.service(sellListService));
			jsp = "sell/list";
			break;
			
		case "/sell/schList.do":
			String brand = request.getParameter("brand");
			String model = request.getParameter("model");
			String year = request.getParameter("year");
			String grade = request.getParameter("cargrade");
			String spec = request.getParameter("spec");
			System.out.println("brand : "+brand+"\n model : "+model+
					"\n year : "+year+"\n grade : "+grade+"\n spec : "+spec);
			
			String[] con = {brand, model, year, grade, spec};
			request.setAttribute("list", Execute.service(sellSchListService, pageObject, con));
			
			request.setAttribute("carBrandList", Execute.service(carBrandListService));
			request.setAttribute("carClassList", Execute.service(carClassListService));
			request.setAttribute("modelList", Execute.service(kModelListService));
			request.setAttribute("modelList", Execute.service(hModelListService));
			request.setAttribute("modelList", Execute.service(sModelListService));
			request.setAttribute("modelList", Execute.service(ssModelListService));
			request.setAttribute("modelList", Execute.service(gmModelListService));
			
			jsp = "sell/list";
			break;
			
		case "/sell/view.do":
			int no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("dto", Execute.service(sellViewService, no));
			jsp = "sell/view";
			break;
			
		case "/sell/writeForm.do":
			request.setAttribute("carBrandList", Execute.service(carBrandListService));
			request.setAttribute("carClassList", Execute.service(carClassListService));
			request.setAttribute("kModelList", Execute.service(kModelListService));
			request.setAttribute("hModelList", Execute.service(hModelListService));
			request.setAttribute("sModelList", Execute.service(sModelListService));
			request.setAttribute("ssModelList", Execute.service(ssModelListService));
			request.setAttribute("gmModelList", Execute.service(gmModelListService));
			System.out.println(request.getAttribute("carBrandList"));
			System.out.println("carItemsList -->"+request.getAttribute("carItemsList"));
//			List<CarItemsDTO> list = (List<CarItemsDTO>) Execute.service(carItemsListService);
//			CarItemsDTO cidto;
//			List<String> model = new ArrayList<String>();
//			List<Object> year = new ArrayList<Object>();
//			List<String> cargrade = new ArrayList<String>();
//			for(int i = 0; i < list.size(); i++) {
//				cidto = list.get(i);
////				System.out.println("List dto -->>"+ dto);
//				while(!model.contains(cidto.getModel())) {
//					model.add(cidto.getModel());
////					request.setAttribute("carItems", model);
////					System.out.println("Item lsit -->>" + model);
//				}
//				while(!year.contains(cidto.getYear())) {
//					year.add(cidto.getYear());
////					year.add(cidto.getGrade());
//					request.setAttribute("carItems", year);
////					request.setAttribute("carItems", cargrade);
//				}
//				while(!cargrade.contains(cidto.getGrade())) {
//					cargrade.add(cidto.getGrade());
//					request.setAttribute("carItems", cargrade);
//				}
//				
//			}
//			System.out.println("model : "+model.toString());
//			System.out.println("year : "+year.toString());
//			System.out.println("cargrade : "+cargrade.toString());
			jsp = "sell/writeForm";
			break;
			
		case "/sell/write.do":
			String uploadPath = FileUtil.realPath(request, path);
			MultipartRequest multi = new MultipartRequest(request, uploadPath,
					size, "utf-8",	new DefaultFileRenamePolicy());	
			System.out.println("sellwrite 시작");
			Execute.service(sellWriteService, getSellDTO(multi));
			System.out.println("attachwrite 시작");
			Execute.service(attachmentWriteService,getDTO(multi, uploadPath));
			System.out.println("categorywrite 시작");
			Execute.service(categoryWriteService, getCategoryDTO(multi));
			System.out.println("caroptionwrite 시작");
			Execute.service(caroptionWriteService, getCaroptionDTO(multi));
			jsp = "redirect:list.do?page=1&perPageNum="+perPageNumStr;
			
			break;
			
		case "/sell/updateForm.do":
			System.out.println("sell.updateForm");
			System.out.println("no: "+Integer.parseInt(request.getParameter("no")));
			request.setAttribute("carBrandList", Execute.service(carBrandListService));
			request.setAttribute("carClassList", Execute.service(carClassListService));
			request.setAttribute("dto", Execute.service(sellViewService, Integer.parseInt(request.getParameter("no"))));
			
			jsp = "sell/updateForm";
			
			break;
			
		case "/sell/update.do":
			System.out.println("sell.update");
			uploadPath = FileUtil.realPath(request, path);
			multi = new MultipartRequest(request, uploadPath,
					size, "utf-8",	new DefaultFileRenamePolicy());
			no = Integer.parseInt(multi.getParameter("no"));
			
			Execute.service(sellUpdateService, getUpdateDTO(multi));
			Execute.service(sellCategoryUpdateService, getUpdateCategoryDTO(multi));
			Execute.service(sellOptionUpdateService, getCaroptionDTO(multi));


			String[] del = multi.getParameterValues("deleteFile");
			AttachmentDTO dto = getDTO(multi, uploadPath);
			deleteFile(request, del, dto);
			Execute.service(sellFileUpdateService, dto);
			
			jsp = "redirect:view.do?no="+no;
			
			break;
			
		case "/sell/delete.do":
			System.out.println("execute().delete");
			// -> 반드시 리스트에서 부터 들어와야 한다.
			no = Integer.parseInt(request.getParameter("no"));
			Execute.service(attachmentDeleteService, no);
			Execute.service(categoryDeleteService, no);
			Execute.service(caroptionDeleteService, no);
			Execute.service(sellDeleteService, no);
			
			// 서버에 올린 파일 지우기
//			FileUtil.deleteFile(FileUtil.realPath(request,
//					request.getParameter("deleteFile")));
			// 자동으로 리스트로 이동시켜야 한다.
			jsp ="redirect:list.do?page=1&perPageNum="
					+request.getParameter("perPageNum");
			break;
			
		case "/sell/complete.do":
			Execute.service(sellcompleteService, Integer.parseInt(request.getParameter("no")));
			
			jsp = "redirect:list.do?page=1&perPageNum="+request.getParameter("perPageNum");
			break;
		default:
			
			break;
		}//end of switch
		System.out.println("SellController.execute().jsp:" + jsp);
		return jsp;
	}// end of execute
	
	// 글쓰기 할때 sellWriteService에 사용되는 메서드
	private SellDTO getSellDTO(MultipartRequest multi) throws Exception {
		
//		String uploadPath = FileUtil.realPath(request, path);
//		
//		MultipartRequest multi = new MultipartRequest(request, uploadPath,
//				size, "utf-8",	new DefaultFileRenamePolicy());
		
		SellDTO dto = new SellDTO();
		
		dto.setContent(multi.getParameter("content"));
		dto.setWriter(multi.getParameter("writer"));
		
		return dto;
		
	}//end of getSellDTO()
	
	// 글수정 할때  사용되는 메서드
	private SellDTO getUpdateDTO(MultipartRequest multi) throws Exception {
		
//		String uploadPath = FileUtil.realPath(request, path);
//		
//		MultipartRequest multi = new MultipartRequest(request, uploadPath,
//				size, "utf-8",	new DefaultFileRenamePolicy());
		
		SellDTO dto = new SellDTO();
		dto.setNo(Integer.parseInt(multi.getParameter("no")));
		dto.setContent(multi.getParameter("content"));
		dto.setWriter(multi.getParameter("writer"));
		
		return dto;
		
	}//end of getUpdateDTO()
	
	// 글쓰기 할때 caroptionWriteService
	private CarOptionDTO getCaroptionDTO(MultipartRequest multi) throws Exception {
		
//		String uploadPath = FileUtil.realPath(request, path);
//		
//		MultipartRequest multi = new MultipartRequest(request, uploadPath,
//				size, "utf-8",	new DefaultFileRenamePolicy());
		
		CarOptionDTO codto = new CarOptionDTO();
		
		if(multi.getParameter("navi") != null)
			codto.setNavi(Integer.parseInt(multi.getParameter("navi")));
		if(multi.getParameter("sun") != null)
			codto.setSun(Integer.parseInt(multi.getParameter("sun")));
		if(multi.getParameter("smart") != null)
			codto.setSmart(Integer.parseInt(multi.getParameter("smart")));
		if(multi.getParameter("wind") != null)
			codto.setWind(Integer.parseInt(multi.getParameter("wind")));
		if(multi.getParameter("cruz") != null)
			codto.setCruz(Integer.parseInt(multi.getParameter("cruz")));
		if(multi.getParameter("handle") != null)
			codto.setHandle(Integer.parseInt(multi.getParameter("handle")));
		if(multi.getParameter("ldws") != null)
			codto.setLdws(Integer.parseInt(multi.getParameter("ldws")));
		if(multi.getParameter("aeb") != null)
			codto.setAeb(Integer.parseInt(multi.getParameter("aeb")));
		if(multi.getParameter("airbag") != null)
			codto.setAirbag(Integer.parseInt(multi.getParameter("airbag")));
		if(multi.getParameter("mirror") != null)
			codto.setMirror(Integer.parseInt(multi.getParameter("mirror")));
		if(multi.getParameter("tpms") != null)
			codto.setTpms(Integer.parseInt(multi.getParameter("tpms")));
		if(multi.getParameter("trunk") != null)
			codto.setTrunk(Integer.parseInt(multi.getParameter("trunk")));
		if(multi.getParameter("autolight") != null)
			codto.setAutolight(Integer.parseInt(multi.getParameter("autolight")));
		if(multi.getParameter("wipper") != null)
			codto.setWipper(Integer.parseInt(multi.getParameter("wipper")));
		if(multi.getParameter("parking") != null)
			codto.setParking(Integer.parseInt(multi.getParameter("parking")));
		if(multi.getParameter("hot") != null)
			codto.setHot(Integer.parseInt(multi.getParameter("hot")));
		if(multi.getParameter("bluetooth") != null)
			codto.setBluetooth(Integer.parseInt(multi.getParameter("bluetooth")));
		if(multi.getParameter("hipass") != null)
			codto.setHipass(Integer.parseInt(multi.getParameter("hipass")));
		if(multi.getParameter("sheet") != null)
			codto.setSheet(Integer.parseInt(multi.getParameter("sheet")));
		if(multi.getParameter("wheel") != null)
			codto.setWheel(Integer.parseInt(multi.getParameter("wheel")));
		if(multi.getParameter("pano") != null)
			codto.setPano(Integer.parseInt(multi.getParameter("pano")));
		if(multi.getParameter("ledlight") != null)
			codto.setLedlight(Integer.parseInt(multi.getParameter("ledlight")));
		if(multi.getParameter("airsus") != null)
			codto.setAirsus(Integer.parseInt(multi.getParameter("airsus")));
		if(multi.getParameter("ctcontent") != null)
			codto.setCtcontent(multi.getParameter("ctcontent"));
		if(multi.getParameter("no") != null)
			codto.setSell_no(Integer.parseInt(multi.getParameter("no")));
		
		return codto;
		
		
		
	}
	
	// 주로 글쓰기할때 첨부파일에 사용되는 메서드
	private AttachmentDTO getDTO(String file1, String file2, String file3, String file4, String file5, String file6, String file7, 
			String file8, String file9, String file10, String file11, String file12, String file13, String file14, String file15, String file16, 
			String file17, String file18, String file19, String file20) {
		AttachmentDTO dto = new AttachmentDTO();
		// 이미지 등록 시 에는 반드시 입력되어야 한다.
		// 그러나 수정 시에는 이미지를 그대로 사용하고자 할때는 변경되지 않는다. -> 데이터가 들어오지 않는다.
		if(file1 != null && !file1.equals("") && !file1.equals(path+"null")) {
			dto.setFile1(file1);
		}
		
		if(file2 != null && !file2.equals("") && !file2.equals(path+"null")) {
			dto.setFile2(file2);
		}
		
		if(file3 != null && !file3.equals("") && !file3.equals(path+"null")) {
			dto.setFile3(file3);
		}
		
		if(file4 != null && !file4.equals("") && !file4.equals(path+"null")) {
			dto.setFile4(file4);
		}
		
		if(file5 != null && !file5.equals("") && !file5.equals(path+"null")) {
			dto.setFile5(file5);
		}
		
		if(file6 != null && !file6.equals("") && !file6.equals(path+"null")) {
			dto.setFile6(file6);
		}
		
		if(file7 != null && !file7.equals("") && !file7.equals(path+"null")) {
			dto.setFile7(file7);
		}
		
		if(file8 != null && !file8.equals("") && !file8.equals(path+"null")) {
			dto.setFile8(file8);
		}
		if(file9 != null && !file9.equals("") && !file9.equals(path+"null")) {
			dto.setFile9(file9);
		}
		
		if(file10 != null && !file10.equals("") && !file10.equals(path+"null")) {
			dto.setFile10(file10);
		}
		
		if(file11 != null && !file11.equals("") && !file11.equals(path+"null")) {
			dto.setFile11(file11);
		}
		
		if(file12 != null && !file12.equals("") && !file12.equals(path+"null")) {
			dto.setFile12(file12);
		}
		
		if(file13 != null && !file13.equals("") && !file13.equals(path+"null")) {
			dto.setFile13(file13);
		}
		
		if(file14 != null && !file14.equals("") && !file14.equals(path+"null")) {
			dto.setFile14(file14);
		}
		
		if(file15 != null && !file15.equals("") && !file15.equals(path+"null")) {
			dto.setFile15(file15);
		}
		
		if(file16 != null && !file16.equals("") && !file16.equals(path+"null")) {
			dto.setFile16(file16);
		}
		
		if(file17 != null && !file17.equals("") && !file17.equals(path+"null")) {
			dto.setFile17(file17);
		}
		
		if(file18 != null && !file18.equals("") && !file18.equals(path+"null")) {
			dto.setFile18(file18);
		}
		
		if(file19 != null && !file19.equals("") && !file19.equals(path+"null")) {
			dto.setFile19(file19);
		}
		
		if(file20 != null && !file20.equals("") && !file20.equals(path+"null")) {
			dto.setFile20(file20);
		}

		return dto;
	}
	
	// 주로 글수정할때 첨부파일에 사용되는 메서드
	private AttachmentDTO getDTO(String file1, String file2, String file3, String file4, String file5, String file6, String file7, 
			String file8, String file9, String file10, String file11, String file12, String file13, String file14, String file15, String file16, 
			String file17, String file18, String file19, String file20, String[] del) {
		AttachmentDTO dto = new AttachmentDTO();
		// 이미지 등록 시 에는 반드시 입력되어야 한다.
		// 그러나 수정 시에는 이미지를 그대로 사용하고자 할때는 변경되지 않는다. -> 데이터가 들어오지 않는다.
		if(file1 != null && !file1.equals("") && !file1.equals(path+"null")) {
			dto.setFile1(file1);
		} else {
			file1 = del[0];
			dto.setFile1(file1);
		}
		
		if(file2 != null && !file2.equals("") && !file2.equals(path+"null")) {
			dto.setFile2(file2);
		} else {
			file2 = del[1];
			dto.setFile2(file2);
		}
		
		if(file3 != null && !file3.equals("") && !file3.equals(path+"null")) {
			dto.setFile3(file3);
		} else {
			file3 = del[2];
			dto.setFile3(file3);
		}
		
		if(file4 != null && !file4.equals("") && !file4.equals(path+"null")) {
			dto.setFile4(file4);
		} else {
			file4 = del[3];
			dto.setFile4(file4);
		}
		
		if(file5 != null && !file5.equals("") && !file5.equals(path+"null")) {
			dto.setFile5(file5);
		} else {
			file5 = del[4];
			dto.setFile5(file5);
		}
		
		if(file6 != null && !file6.equals("") && !file6.equals(path+"null")) {
			dto.setFile6(file6);
		} else {
			file6 = del[5];
			dto.setFile6(file6);
		}
		
		if(file7 != null && !file7.equals("") && !file7.equals(path+"null")) {
			dto.setFile7(file7);
		} else {
			file7 = del[6];
			dto.setFile7(file7);
		}
		
		if(file8 != null && !file8.equals("") && !file8.equals(path+"null")) {
			dto.setFile8(file8);
		} else {
			file8 = del[7];
			dto.setFile8(file8);
		}
		
		if(file9 != null && !file9.equals("") && !file9.equals(path+"null")) {
			dto.setFile9(file9);
		} else {
			file9 = del[8];
			dto.setFile9(file9);
		}
		
		if(file10 != null && !file10.equals("") && !file10.equals(path+"null")) {
			dto.setFile10(file10);
		} else {
			file10 = del[9];
			dto.setFile10(file10);
		}
		
		if(file11 != null && !file11.equals("") && !file11.equals(path+"null")) {
			dto.setFile11(file11);
		} else {
			file11 = del[10];
			dto.setFile11(file11);
		}
		
		if(file12 != null && !file12.equals("") && !file12.equals(path+"null")) {
			dto.setFile12(file12);
		} else {
			file12 = del[11];
			dto.setFile12(file12);
		}
		
		if(file13 != null && !file13.equals("") && !file13.equals(path+"null")) {
			dto.setFile13(file13);
		} else {
			file13 = del[12];
			dto.setFile13(file13);
		}
		
		if(file14 != null && !file14.equals("") && !file14.equals(path+"null")) {
			dto.setFile14(file14);
		} else {
			file14 = del[13];
			dto.setFile14(file14);
		}
		
		if(file15 != null && !file15.equals("") && !file15.equals(path+"null")) {
			dto.setFile15(file15);
		} else {
			file15 = del[14];
			dto.setFile15(file15);
		}
		
		if(file16 != null && !file16.equals("") && !file16.equals(path+"null")) {
			dto.setFile16(file16);
		} else {
			file16 = del[15];
			dto.setFile16(file16);
		}
		
		if(file17 != null && !file17.equals("") && !file17.equals(path+"null")) {
			dto.setFile17(file17);
		} else {
			file17 = del[16];
			dto.setFile17(file17);
		}
		
		if(file18 != null && !file18.equals("") && !file18.equals(path+"null")) {
			dto.setFile18(file18);
		} else {
			file18 = del[17];
			dto.setFile18(file18);
		}
		
		if(file19 != null && !file19.equals("") && !file19.equals(path+"null")) {
			dto.setFile19(file19);
		} else {
			file19 = del[18];
			dto.setFile19(file19);
		}
		
		if(file20 != null && !file20.equals("") && !file20.equals(path+"null")) {
			dto.setFile20(file20);
		} else {
			file20 = del[19];
			dto.setFile20(file20);
		}
		
		return dto;
	}
	
	// 주로 글수정할때 첨부파일 사용되는 메서드
	private AttachmentDTO getDTO(int sell_no, String file1, String file2, String file3, String file4, String file5, String file6, String file7, 
			String file8, String file9, String file10, String file11, String file12, String file13, String file14, String file15, String file16, 
			String file17, String file18, String file19, String file20, String[] del) {
		AttachmentDTO dto = getDTO(file1, file2, file3, file4, file5, file6, file7, file8, file9, file10, file11, file12, file13, file14, 
				file15, file16, file17, file18, file19, file20, del);
		dto.setSell_no(sell_no);
		
		return dto;
	}
	
	private AttachmentDTO getDTO(MultipartRequest multi, String uploadPath) throws Exception {
		
		// 파일을 업로드할 서버의 절대위치 : 하드디스트의 위치
//		String uploadPath = FileUtil.realPath(request, path);
//		System.out.println(uploadPath);
		// new MultipartRequest(request, 파일이올라간하드디스크의위치와파일명,
		// 용량제한, 엔코딩, 중복처리프로그램) - 생성이되면 첨부파일이 바로 올라간다.
//		MultipartRequest multi = new MultipartRequest(request, uploadPath,
//				size, "utf-8",	new DefaultFileRenamePolicy());

		// DB에 저장할 첨부파일 정보 : 웹위치+서버의파일명
		String file1 = path + multi.getFilesystemName("file1");
		String file2 = path + multi.getFilesystemName("file2");
		String file3 = path + multi.getFilesystemName("file3");
		String file4 = path + multi.getFilesystemName("file4");
		String file5 = path + multi.getFilesystemName("file5");
		String file6 = path + multi.getFilesystemName("file6");
		String file7 = path + multi.getFilesystemName("file7");
		String file8 = path + multi.getFilesystemName("file8");
		String file9 = path + multi.getFilesystemName("file9");
		String file10 = path + multi.getFilesystemName("file10");
		String file11 = path + multi.getFilesystemName("file11");
		String file12 = path + multi.getFilesystemName("file12");
		String file13 = path + multi.getFilesystemName("file13");
		String file14 = path + multi.getFilesystemName("file14");
		String file15 = path + multi.getFilesystemName("file15");
		String file16 = path + multi.getFilesystemName("file16");
		String file17 = path + multi.getFilesystemName("file17");
		String file18 = path + multi.getFilesystemName("file18");
		String file19 = path + multi.getFilesystemName("file19");
		String file20 = path + multi.getFilesystemName("file20");
		System.out.println("ImageController.execute().fileName:" + file1);
		
		String[] del = multi.getParameterValues("deleteFile");
		// 저장된 파일 사이즈를 줄여서 리스트에 표시하기 위한 파일로 복사 -> dog01.jpg => s_dog01.jpg
		// webjjangma 카페에서 업로드 검색 리사이징 프로그램 참조 + 라이브러리 등록해서 사용
		// ImageResizing.imageResizing(realPath, 이미지 파일명, 앞첨자, 너비, 높이)
		// 첨부파일이 있는 경우만 처리를 한다. 첨부가 없는 경우 fileName
		if(file1 != null && !file1.equals("")
				&& !file1.equals(path + "null"))
			ImageResizing.imageResizing(uploadPath,
					multi.getFilesystemName("file1"), "s_", 300);
		
		// 한페이지에 표시할 데이터의 갯수
		perPageNumStr = multi.getParameter("perPageNum");
		System.out.println("perPageNumStr : "+perPageNumStr);

		sell_NoStr = multi.getParameter("sell_no");
		System.out.println("sell_NoStr : "+sell_NoStr);
		
		noStr = multi.getParameter("no");
		System.out.println("noStr : "+noStr);
		
		// 글번호가 들어오면 - 업데이터(수정)
		if(noStr != null && !noStr.equals("")) {
			return getDTO(Integer.parseInt(noStr),
					file1, file2, file3, file4, file5, file6, file7, file8, file9, file10, file11, file12, file13, file14, 
					file15, file16, file17, file18, file19, file20, del);
		}
		// 글번호가 들어오지 않으면 - 글쓰기
		return getDTO(
				file1, file2, file3, file4, file5, file6, file7, file8, file9, file10, file11, file12, file13, file14, 
				file15, file16, file17, file18, file19, file20);
	}
	
	private CategoryDTO getCategoryDTO(MultipartRequest multi) throws Exception {
		
//		String uploadPath = FileUtil.realPath(request, path);
//		
//		MultipartRequest multi = new MultipartRequest(request, uploadPath,
//				size, "utf-8",	new DefaultFileRenamePolicy());	
		
		CategoryDTO cgdto = new CategoryDTO();
		
		cgdto.setDistance(Integer.parseInt(multi.getParameter("distance")));
		cgdto.setPrice(Integer.parseInt(multi.getParameter("price")));
		cgdto.setModel(multi.getParameter("model"));
		cgdto.setBrand(multi.getParameter("brand"));
		cgdto.setGrade(multi.getParameter("cargrade"));
		cgdto.setYear(multi.getParameter("year"));
		cgdto.setLocation(multi.getParameter("location"));
		cgdto.setFuel(multi.getParameter("fuel"));
		cgdto.setCarnumber(multi.getParameter("carnumber"));
		cgdto.setCarclass(multi.getParameter("carclass"));
		cgdto.setSpec(multi.getParameter("spec"));
		cgdto.setColor(multi.getParameter("color"));
		cgdto.setTrans(multi.getParameter("trans"));
		
		return cgdto;
		
	}

	private CategoryDTO getUpdateCategoryDTO(MultipartRequest multi) throws Exception {
		
//		String uploadPath = FileUtil.realPath(request, path);
//		
//		MultipartRequest multi = new MultipartRequest(request, uploadPath,
//				size, "utf-8",	new DefaultFileRenamePolicy());	
		
		CategoryDTO cgdto = new CategoryDTO();
		cgdto.setSell_no(Integer.parseInt(multi.getParameter("no")));
		cgdto.setDistance(Integer.parseInt(multi.getParameter("distance")));
		cgdto.setPrice(Integer.parseInt(multi.getParameter("price")));
		cgdto.setModel(multi.getParameter("model"));
		cgdto.setBrand(multi.getParameter("brand"));
		cgdto.setGrade(multi.getParameter("cargrade"));
		cgdto.setYear(multi.getParameter("year"));
		cgdto.setLocation(multi.getParameter("location"));
		cgdto.setFuel(multi.getParameter("fuel"));
		cgdto.setCarnumber(multi.getParameter("carnumber"));
		cgdto.setCarclass(multi.getParameter("carclass"));
		cgdto.setSpec(multi.getParameter("spec"));
		cgdto.setColor(multi.getParameter("color"));
		cgdto.setTrans(multi.getParameter("trans"));
		
		return cgdto;
		
	}// end getupdate
	
	private void deleteFile(HttpServletRequest request, String[] del, AttachmentDTO dto) throws Exception {
		System.out.println("deleteFile");
		if(!dto.getFile1().equals(del[0]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[0]));
		if(!dto.getFile2().equals(del[1]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[1]));
		if(!dto.getFile3().equals(del[2]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[2]));
		if(!dto.getFile4().equals(del[3]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[3]));
		if(!dto.getFile5().equals(del[4]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[4]));
		if(!dto.getFile6().equals(del[5]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[5]));
		if(!dto.getFile7().equals(del[6]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[6]));
		if(!dto.getFile8().equals(del[7]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[7]));
		if(!dto.getFile9().equals(del[8]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[8]));
		if(!dto.getFile10().equals(del[9]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[9]));
		if(!dto.getFile11().equals(del[10]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[10]));
		if(!dto.getFile12().equals(del[11]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[11]));
		if(!dto.getFile13().equals(del[12]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[12]));
		if(!dto.getFile14().equals(del[13]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[13]));
		if(!dto.getFile15().equals(del[14]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[14]));
		if(!dto.getFile16().equals(del[15]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[15]));
		if(!dto.getFile17().equals(del[16]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[16]));
		if(!dto.getFile18().equals(del[17]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[17]));
		if(!dto.getFile19().equals(del[18]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[18]));
		if(!dto.getFile20().equals(del[19]))
			FileUtil.deleteFile(FileUtil.realPath(request, del[19]));
	}
	
}//end of SellController
