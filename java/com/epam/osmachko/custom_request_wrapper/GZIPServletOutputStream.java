package com.epam.osmachko.custom_request_wrapper;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class GZIPServletOutputStream extends ServletOutputStream {

	private GZIPOutputStream gzioOutPutStream = null;
	
	public GZIPServletOutputStream(OutputStream outPut) throws IOException {
		super();
		this.gzioOutPutStream = new GZIPOutputStream(outPut);
	}

	  @Override
	  public void close() throws IOException {
	    this.gzioOutPutStream.close();
	  }

	  @Override
	  public void flush() throws IOException {
	    this.gzioOutPutStream.flush();
	  }

	  @Override
	  public void write(byte b[]) throws IOException {
	    this.gzioOutPutStream.write(b);
	  }

	  @Override
	  public void write(byte b[], int off, int len) throws IOException {
	    this.gzioOutPutStream.write(b, off, len);
	  }

	  @Override
	  public void write(int b) throws IOException {
	     this.gzioOutPutStream.write(b);
	  }

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
		// TODO Auto-generated method stub
		
	}


	
	
}
