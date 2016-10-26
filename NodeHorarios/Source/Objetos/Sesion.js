var Sesion = function(asignatura,horas,curso){
    this.asignatura = asignatura;
    this.horas = horas;
    this.curso = curso;

    this.getHoras = function(){
        return this.horas;
    }

    this.getAsignatura = function(){
        return this.asignatura;
    }
	
	this.getHoras = function(){
		return this.horas;
	}
}

module.exports = Sesion;