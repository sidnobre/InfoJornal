package br.ufc.quixada.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.ufc.quixada.annotation.NoPageCache;

@Intercepts
@RequestScoped
@AcceptsWithAnnotations(NoPageCache.class)
public class NoPageCacheInterceptor {
	
	@Inject private HttpServletResponse response;
	
	@BeforeCall
	public void intercept(){
		response.setHeader("Expires", "Wed, 31 Dec 1969 21:00:00 GMT");
		
		// HTTP/1.1
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		
		// HTTP/1.1 Internet Explorer
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		
		// HTTP/1.0
		response.setHeader("Pragma", "no-cache");
	}
}
