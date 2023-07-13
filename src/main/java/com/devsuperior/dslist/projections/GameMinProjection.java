package com.devsuperior.dslist.projections;

public interface GameMinProjection {

	// Nessa interface precisam ser criados métodos Get condizentes com a consulta SQL
	// Precisam ser criados Get`s para cada dado que a consulta retorna
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl(); 
	String getShortDescription();
	Integer getPosition();

}
