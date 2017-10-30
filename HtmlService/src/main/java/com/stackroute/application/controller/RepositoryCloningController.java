//package com.stackroute.application.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.stackroute.application.exception.InternalRepositoryException;
//import com.stackroute.application.exception.UrlNotRepositoryException;
//import com.stackroute.application.model.RepositoryDetails;
//import com.stackroute.application.service.SvnRepositoryServiceImpl;
//
//@RestController
//public class RepositoryCloningController {
//	@Autowired
//	private SvnRepositoryServiceImpl _svnservice;
//	
//	/*
//	perform checkout
//	*/
//	@PostMapping(value={"/checkout"})
//	public ResponseEntity<String> performCheckout(@Valid @RequestBody RepositoryDetails repositorydetails) throws UrlNotRepositoryException, InternalRepositoryException {
//		/*
//		validate your incoming data // TODO: needed
//		*/
//		_svnservice.checkUrlValidity(repositorydetails.getUrl());
//		if(_svnservice.checkPathValidity(repositorydetails.getFolderpath())) {
//			/*
//			handle custom exception // TODO: needed
//			*/
//			_svnservice.cloneRepository(repositorydetails);
//			return new ResponseEntity<String> ("Checkout done.", HttpStatus.CREATED);
//		} else {
//			return new ResponseEntity<String> ("FolderPath Details Wrong.", HttpStatus.BAD_REQUEST);
//		}
//	}
//}
