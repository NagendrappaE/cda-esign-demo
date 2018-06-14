/**
 * 
 */
package com.evolvus.ebean;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@XmlRootElement(name = "emandate")


@JsonPropertyOrder(
		{"header",
		"response"
		
		})
public class Emandate
{
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Request request;

    private Header header;
    
    
    private Response response;


	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}


	public Header getHeader() {
		return header;
	}


	public void setHeader(Header header) {
		this.header = header;
	}


	public Response getResponse() {
		return response;
	}


	public void setResponse(Response response) {
		this.response = response;
	}

    
}
			

