package com.epam.osmachko.custom_request_wrapper;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZIPServletResponseWrapper extends HttpServletResponseWrapper {

	private PrintWriter printWriter = null;
	
	private GZIPServletOutputStream gzipServletOutputStream = null;
	
	
	public GZIPServletResponseWrapper(HttpServletResponse response) {
		super(response);
	}
	
	public void close() throws IOException {
	      if (this.printWriter != null) {
	          this.printWriter.close();
	      }
	      if (this.gzipServletOutputStream != null) {
	          this.gzipServletOutputStream.close();
	      }
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		 if (this.printWriter != null) {
		      throw new IllegalStateException(
		        "PrintWriter obtained already - cannot get OutputStream");
		    }
		    if (this.gzipServletOutputStream == null) {
		      this.gzipServletOutputStream = new GZIPServletOutputStream(getResponse().getOutputStream());
		    }
		    return this.gzipServletOutputStream;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		 if (this.printWriter == null && this.gzipServletOutputStream != null) {
		       throw new IllegalStateException(
		         "OutputStream obtained already - cannot get PrintWriter");
		     }
		     if (this.printWriter == null) {
		       this.gzipServletOutputStream = new GZIPServletOutputStream(
		         getResponse().getOutputStream());
		       this.printWriter      = new PrintWriter(new OutputStreamWriter(
		       this.gzipServletOutputStream, getResponse().getCharacterEncoding()));
		     }
		     return this.printWriter;
	}

	@Override
	public void setContentLength(int len) {
		super.setContentLength(len);
	}

	@Override
	public void flushBuffer() throws IOException {
	    if(this.printWriter != null) {
	      this.printWriter.flush();
	    }

	    IOException exception1 = null;
	    try{
	      if(this.gzipServletOutputStream != null) {
	        this.gzipServletOutputStream.flush();
	      }
	    } catch(IOException e) {
	        exception1 = e;
	    }
	    IOException exception2 = null;
	    try {
	      super.flushBuffer();
	    } catch(IOException e){
	      exception2 = e;
	    }
	    if(exception1 != null) throw exception1;
	    if(exception2 != null) throw exception2;
	    
	}

	
	
	
}
