/**
 * 
 */
package com.sunshine.test.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

/**
 * @author lenovo
 * 
 */
public class FileDownAction implements Action {

	private String contentType;

	private String contentDisposition;

	public String getContentType() {
		return "application/zip";
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentDisposition() {
		return "attachment;filename='abc.zip'";
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1424813211290837982L;

	private String inputPath;

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public InputStream getInputStream() throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(
				inputPath);
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
