var Curso = function(nombre,curso,titulacion){
	if(nombre==null){
		throw Error("Grupo sin nombre");
	}
	this.nombre = nombre;
	this.curso = curso;
	this.titulacion = titulacion;
	
	this.getGrupo = function(){
		return this.nombre + " "+this.curso+ " "+this.titulacion.nombre;
	}
	this.getNombre = function(){
		return this.nombre;
	}
	this.getCurso = function(){
		return this.curso;
	}

}

module.exports = Curso;