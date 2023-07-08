package com.ec.ecuador.controlador;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ec.ecuador.entidad.Cliente;
import com.ec.ecuador.repositorio.ClienteRepository;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public ResponseEntity<?> productos() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Cliente> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<Cliente>) repository.findAll();
//			cfgPais = GlobalValue.LISTACFGPAIS;
			httpHeaders.add("STATUS", "1");
			return new ResponseEntity<List<Cliente>>(respuesta, httpHeaders, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<String>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
