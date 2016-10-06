package br.com.PersistStruts.actions;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ClassLoaderUtil;

import br.com.PersistStruts.modelo.Cliente;
import br.com.PersistStruts.servicos.ClienteServico;
import br.com.PersistStruts.servicos.Conexao;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class RelatorioAction extends ActionSupport implements ParameterAware, ServletResponseAware {
	
	private Map<String, Object> params;

	private HttpServletResponse response;
	
	@Autowired 
	protected ServletContext servletContext;
	
	@Autowired
	Conexao conn;
	
	@Autowired
	ClienteServico clienteServico;

	
	@Autowired
	DataSource dataSource;
	
	
	
	@Override
	public String execute() throws Exception {
		final String nome =(String) params.get("codigo");
		String arqin = servletContext.getRealPath("/rel/" + new StringBuilder(nome).append(".jasper").toString());
		JasperPrint impressao = null;
		JRDataSource dados = new JRBeanCollectionDataSource(null);

		if(nome.equals("rel01") ){
			dados = new JRBeanCollectionDataSource(clienteServico.pesquisarCliente(),false);
			
		}
		if(nome.equals("rel02") ){
			LinkedList<Cliente> lista = new LinkedList<Cliente>();
			lista.add(clienteServico.pesquisarId(Integer.parseInt((String) params.get("id"))));
			dados = new JRBeanCollectionDataSource(lista,false);
}
		
		
		impressao = JasperFillManager.fillReport(arqin, this.params, dados);
		byte[] bytes = JasperExportManager.exportReportToPdf(impressao);
		byte[] arquivo = bytes;
		String nomeDoArquivo = new StringBuilder(nome).append(".pdf").toString();
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment;filename=".concat(nomeDoArquivo));
		response.setContentLength(arquivo.length);
		ServletOutputStream sos = response.getOutputStream();
		sos.write(arquivo, 0, arquivo.length);
		sos.flush();
		sos.close();
		return null;
	}
	
	
	
	public String relConection() throws Exception {
		response.setContentType("application/pdf");
		response.setHeader("content-disposition","attachment;filename=" + new StringBuilder("").append((String)params.get("codigo")).append(".pdf").toString());
		Connection connection = dataSource.getConnection();	
		
		StringBuilder sb = new StringBuilder("../../rel/").append((String)params.get("codigo")).append(".jasper");
		InputStream jrFile = ClassLoaderUtil.getResourceAsStream(sb.toString(), this.getClass());
		JasperRunManager.runReportToPdfStream(jrFile, response.getOutputStream(), this.params,connection);
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



	public DataSource getDataSource() {
		return dataSource;
	}



	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	

	

}
