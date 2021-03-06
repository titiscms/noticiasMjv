package br.com.mjv.noticias.noticia.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mjv.noticias.noticia.dao.NoticiaDao;
import br.com.mjv.noticias.noticia.model.Noticia;

@Service
public class NoticiaServiceImpl implements NoticiaService {

	@Autowired
	private NoticiaDao dao;
	
	@Override
	public List<Noticia> listar() {		
		return dao.listarTodos();
	}
	
	@Override
	public Page<Noticia> listar(Pageable pageable) {
		return dao.listarTodos(pageable);
	}

	@Override
	public Long adicionar(Noticia noticia) {
		noticia.setDataCriacao(OffsetDateTime.now());
		return dao.adicionar(noticia);
	}
	
	@Override
	public Noticia buscarPorId(Long noticiaId) {
		Noticia noticia = dao.buscarPorId(noticiaId);
		return noticia;
	}
	
}
