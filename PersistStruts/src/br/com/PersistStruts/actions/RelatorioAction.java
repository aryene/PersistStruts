package br.com.PersistStruts.actions;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ClassLoaderUtil;

import br.com.PersistStruts.servicos.Conexao;
import net.sf.jasperreports.engine.JasperRunManager;

@Service
public class RelatorioAction extends ActionSupport implements ParameterAware, ServletResponseAware {
	
	private Map<String, Object> params;

	private HttpServletResponse response;
	
	@Autowired
	Conexao conn;
	
	
	@Override
	public String execute() throws Exception {
		this.response.setContentType("application/pdf");
		this.response.setHeader("content-disposition","attachment;filename=" + new StringBuilder("").append((String)params.get("codigo")).append(".pdf").toString());
		//Connection connection =	
		StringBuilder sb = new StringBuilder("../../rel/").append((String)params.get("codigo")).append(".jasper");
		InputStream jrFile = ClassLoaderUtil.getResourceAsStream(sb.toString(), this.getClass());
		JasperRunManager.runReportToPdfStream(jrFile, this.response.getOutputStream(), this.params,conn.getConection());
		return null;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.params = new HashMap<>();
		for(String key: parameters.keySet()) {
			this.params.put(key, parameters.get(key)[0]);
		}
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	

	

}
