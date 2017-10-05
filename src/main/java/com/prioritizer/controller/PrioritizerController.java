package com.prioritizer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prioritizer.bean.ClassMethods;
import com.prioritizer.bean.PriorityIdentifier;
import com.prioritizer.bean.PriorityList;
import com.prioritizer.dao.DBConnector;
import com.prioritizer.validation.ActionResponse;
import com.prioritizer.validation.Feedback;

@RestController
@RequestMapping(value = "/configurator")
public class PrioritizerController {

	@Autowired
	DBConnector dbConnector;

	@RequestMapping(method = RequestMethod.POST, value = "/priorities")
	public ResponseEntity<ActionResponse> publishCoupon(@RequestBody PriorityList priorities) {
		ActionResponse response = new ActionResponse();
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		boolean isOperationSuccess = false;
		if (priorities.getPriorities() != null) {
			feedbacks.add(new Feedback("operationSuccess", "Coupon posted successfully."));
			isOperationSuccess = true;
		} else {
			feedbacks.add(new Feedback("InvalidPriorities", "Test Priority is Invalid."));
		}
		response.setResponse(feedbacks);
		ResponseEntity<ActionResponse> responseEntity = new ResponseEntity<ActionResponse>(response,
				isOperationSuccess ? HttpStatus.OK : HttpStatus.UNPROCESSABLE_ENTITY);
		return responseEntity;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/priorities")
	public ResponseEntity<PriorityList> getTestPriorities() {
		PriorityList priorityList = new PriorityList();
		priorityList.setPriorities(new ArrayList<ClassMethods>());
		ResponseEntity<PriorityList> responseEntity = new ResponseEntity<PriorityList>(priorityList,
				priorityList.getPriorities().size() == 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
		return responseEntity;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/priorities/{identifier}")
	public ResponseEntity<ActionResponse> CompleteOrder(@PathVariable String identifier) {
		PriorityIdentifier pIdentifier = new PriorityIdentifier(identifier);
		ActionResponse response = new ActionResponse();
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		boolean isOperationSuccess = false;
		if (pIdentifier.getId() != null) {
			feedbacks.add(new Feedback("operationSuccess", "Priorities deleted."));
			isOperationSuccess = true;
		} else {
			feedbacks.add(new Feedback("InvalidPriorityId", "Priority id is not specified."));
		}
		response.setResponse(feedbacks);
		ResponseEntity<ActionResponse> responseEntity = new ResponseEntity<ActionResponse>(response,
				isOperationSuccess ? HttpStatus.OK : HttpStatus.UNPROCESSABLE_ENTITY);
		return responseEntity;
	}

}
