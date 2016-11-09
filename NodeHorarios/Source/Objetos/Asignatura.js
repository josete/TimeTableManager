var Asignatura = function(nombre,curso,titulacion,profesor){
	if(nombre==null){
		throw Error("Asignautra sin nombre");
	}
	this.nombre = nombre;
	this.curso = curso;
	this.titulacion = titulacion;
	this.puede = true;
	this.profesor = profesor;

	this.getAsignaturaInfo = function(){
		return this.nombre + " "+this.curso+ " "+this.titulacion.nombre;
	}
	this.getNombre = function(){
		return this.nombre;
	}
	this.getCurso = function(){
		return this.curso;
	}

	this.diaActualPuede = function(){
		return this.puede;
	}
	
	this.setPuede = function(puede){
		this.puede = puede;
	}

	this.getProfesor = function(){
		return profesor;
	}

	this.setProfesor = function(profesor){
		this.profesor = profesor;
	}

}

module.exports = Asignatura;
