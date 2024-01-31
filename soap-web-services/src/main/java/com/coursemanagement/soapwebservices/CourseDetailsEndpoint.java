package com.coursemanagement.soapwebservices;

import java_spring_projects.soap_web_services.courses.CourseDetails;
import java_spring_projects.soap_web_services.courses.GetCourseDetailsRequest;
import java_spring_projects.soap_web_services.courses.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailsEndpoint {
    @PayloadRoot(namespace="http://java-spring-projects/soap-web-services/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(request.getId());
        courseDetails.setName("Microservices course");
        courseDetails.setDescription("Course on Java Microservices");
        response.setCourseDetails(courseDetails);
        return response;
    }
}
