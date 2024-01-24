XMl Structure:
--------------
1. GetCourseDetailsRequest -> GetCourseDetailsResponse
    inputId -> 123 -> output
2. To make your SOAP XML Request unique, add a namespace in your request
3. Define XSD to validate the request sent is correct or not
4. xsi:schemaLocation -> refer your xsd in your request.xml by using xsi:schemaLocation as {namespace} {xsd name}
5. to define xsi -> xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"