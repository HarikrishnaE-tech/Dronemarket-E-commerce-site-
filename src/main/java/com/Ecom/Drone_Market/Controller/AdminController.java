package com.Ecom.Drone_Market.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Ecom.Drone_Market.Model.Category;
import com.Ecom.Drone_Market.Model.Product;
import com.Ecom.Drone_Market.Service.CategoryService;
import com.Ecom.Drone_Market.Service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService; 
	

	@GetMapping("/")
	public String index() {
		return "admin/index";
		
	}
	@GetMapping("/load_addprod")
	public String add_prod(Model m) {
		List<Category> Categories = categoryService.getAllCategory();
		m.addAttribute("categories",Categories);
		return "admin/add_product";
	}
	@GetMapping("/category")
	public String category(Model m) {
		m.addAttribute("categorys", categoryService.getAllCategory());
		return "admin/category";
	}
	
	@PostMapping("/savecategory")
	public String savecategory(@ModelAttribute Category category,@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
		
	String imagename=file!=null ? file.getOriginalFilename():"default.jpg";	
	category.setImageName(imagename);
	Boolean existcategory=	categoryService.existCategory(category.getName());
		if(existcategory) {
			session.setAttribute("errorMsg", "category name already exist");
		}else{
			Category savecategory=categoryService.saveCategory(category);
			if(!ObjectUtils.isEmpty(savecategory)) {
				session.setAttribute("successMsg", "Saved Successfully");
			}else {
		File SaveFile=new ClassPathResource("/static/img").getFile();
		
		Path path = Paths.get(SaveFile.getAbsolutePath() + File.separator + "categoryimage" + File.separator
				+ file.getOriginalFilename());

		System.out.println(path);
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		
				session.setAttribute("successMsg", "Saved Successfully");
			}
			
		}
		
		return "redirect:/admin/category";
	}
	
	@GetMapping("/deleteCategory/{id}")
	public String deletecategory(@PathVariable int id,HttpSession session) {
		Boolean deleteCategory = categoryService.deleteCategory(id);
		if(deleteCategory) {
			session.setAttribute("successMsg"," category Deleted Successfully");
		}
		else{
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/admin/category" ;
		
	}
	
	@GetMapping("/loadEditCategory/{id}")
	public String loadEditcategory(@PathVariable int id,Model m) {
		
	m.addAttribute("category",categoryService.getcategoryById(id));
		
	
	
		return "admin/edit_category";
		
	}
	
	@PostMapping("/updateCategory")
	public String updateCategory(@ModelAttribute Category category, @RequestParam("file") MultipartFile file,HttpSession session) throws IOException {
		
		Category category1 = categoryService.getcategoryById(category.getId());
		String imageName = file.isEmpty() ? category1.getImageName() : file.getOriginalFilename();
		if(!ObjectUtils.isEmpty(category1)) {
			category1.setName(category.getName());
			category1.setIsActive(category.getIsActive());
			category1.setImageName(imageName);
			
		}
		Category updateCategory=categoryService.saveCategory(category1);
		if(!ObjectUtils.isEmpty(updateCategory)) {
			
			
			if (!file.isEmpty()) {
				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "categoryimage" + File.separator
						+ file.getOriginalFilename());

				// System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			}
			
			
			
			
			session.setAttribute("successMsg", "Category updated successfully");
			
		}else {
			session.setAttribute("errorMsg", "something wrong in the server");	
		}
		
		
		return "redirect:/admin/loadEditCategory/" + category1.getId();
		
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(@ModelAttribute Product product,@RequestParam("file")MultipartFile image, HttpSession session) throws IOException {
		
	String imageName=image.isEmpty()? "default.jpg": image.getOriginalFilename();
     product.setImage(imageName);
     Product saveProduct = productService.saveProduct(product);
		if(!ObjectUtils.isEmpty(saveProduct)){
		File SaveFile=new ClassPathResource("/static/img").getFile();
		
		Path path = Paths.get(SaveFile.getAbsolutePath() + File.separator + "productimage" + File.separator
				+ image.getOriginalFilename());

		System.out.println(path);
		Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			session.setAttribute("successMsg", "Product saved Successfully");
		}else {
			session.setAttribute("errorMsg", "internal server error");
		}
		
		return "redirect:/admin/load_addprod";
		
	}
	
	@GetMapping("/products")
	public String loadViewProduct(Model m) {
		m.addAttribute("products",productService.getAllProducts());
		return "/admin/products";
		
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProducts(@PathVariable int id,HttpSession session) {
		Boolean deleteProduct = productService.deleteProduct(id);
		if(deleteProduct) {
			session.setAttribute("successMsg", "Deleted Successfully");
		}
		else {
			session.setAttribute("errorMsg", "internal Server error");
		}
		return "redirect:/admin/products";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}



