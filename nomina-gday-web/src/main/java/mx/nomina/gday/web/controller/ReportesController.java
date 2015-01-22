package mx.nomina.gday.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.servicios.NominaServicio;
import mx.nomina.gday.servicios.ReportesServicio;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reportes")
public class ReportesController {

	@Autowired
	private ReportesServicio reportesServicio;

	@RequestMapping(value="/obtenernominaempleados",method = RequestMethod.POST)
    @ResponseBody
    public void getFile(HttpServletRequest request,HttpServletResponse response) {
		File fileToDownload = null;
        InputStream inputStream = null;
        Integer idNomina=Integer.parseInt(request.getParameter("id1"));
        System.out.println("buscando el registro de nómina:"+idNomina);
 		try{            
			fileToDownload = this.reportesServicio.generarLayoutNominaEmpleados(idNomina,"","");
            inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename="+"layoutNomina"+idNomina+"-empleados.xls"); 
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        }catch(Exception e){            
            e.printStackTrace();
        }
 
    }
}
