package com.stackroute.newz.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.newz.model.News;
import com.stackroute.newz.repository.NewsRepository;

/*
 * Annotate the class with @Controller annotation. @Controller annotation is used to mark
 * any java class as a controller so that Spring can recognize this class as a Controller
 */

@Controller
public class NewsController {
	
	/*
	 * From the problem statement, we can understand that the application
	 * requires us to implement the following functionalities.
	 *
	 * 1. display the list of existing news from the collection. Each news object
	 *    should contain News Id, title, author, description, content and created date.
	 * 2. Add a new news which should contain the News Id, title, author, description, content.
	 * 3. Delete an existing news.
	 */
	
	/*
	 * Get the application context from resources/beans.xml file using ClassPathXmlApplicationContext() class.
	 * Retrieve the News object from the context.
	 * Retrieve the NewsRepository object from the context.
	 */
	

	ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
	
	NewsRepository newsRepo = appContext.getBean("newsrepo", NewsRepository.class);
	News news = appContext.getBean("news", News.class);

	
	/*Define a handler method to read the existing news by calling the getNewsList() method
	 * of the NewsRepository class and add it to the ModelMap which is an implementation of Map
	 * for use when building model data for use with views. it should map to the default URL i.e. "/" */
	
	@GetMapping("/")
	public String getNewsList(ModelMap modelMap) {
		
		List<News> newsList = newsRepo.getNewsList();
		modelMap.addAttribute("newsList", newsList);
		
		return "index";
	}

	
	/*Define a handler method which will read the News data from request parameters and
	 * save the news by calling the addNews() method of NewsRepository class. Please note
	 * that the createdAt field should always be auto populated with system time and should not be accepted
	 * from the user. Also, after saving the news, it should show the same along with existing
	 * news elements. Hence, reading news has to be done here again.
	 * This handler method should map to the URL "/saveNews".
	*/
	
	
	@PostMapping("/saveData")
	public String addNews(@ModelAttribute("newsobj") News news, ModelMap mapNews) {
		
		news.setPublishedAt(LocalDateTime.now());
		newsRepo.addNews(news);
		
		return "redirect:/";
	}
	
//	@PostMapping("/saveData")
//	public String addNews( @RequestParam("newsId") int newsId,
//			@RequestParam("title") String title, @RequestParam("author") String author,
//			@RequestParam("description") String description, @RequestParam("content") String content,
//			ModelMap mapNews) {
//		
//		News news1 = new News();
//		news1.setNewsId(newsId);
//		news1.setTitle(title);
//		news1.setAuthor(author);
//		news1.setDescription(description);
//		news1.setContent(content);
//		news1.setPublishedAt(LocalDateTime.now());
//		newsRepo.addNews(news1);
//		
//		return "redirect:/";
//	}

	
	
	/* Define a handler method to delete an existing news by calling the deleteNews() method
	 * of the NewsRepository class
	 * This handler method should map to the URL "/deleteNews"
	*/
	
	@GetMapping("/deletenews")
	public String deleteNews(@RequestParam("newsId") int newsId, ModelMap mapNews) {
		
		newsRepo.deleteNews(newsId);

		return "redirect:/";
	}
	
}