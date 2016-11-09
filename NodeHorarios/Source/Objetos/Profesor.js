var Profesor = function(nombre){
	if(nombre==null){
		throw Error("Profesor sin nombre");
	}
	this.nombre = nombre;
    this.diasConClase = {};

	this.getNombre = function(){
		return this.nombre;
	}

    this.anadirClase = function(key,asignatura){
        this.diasConClase[key] = asignatura;
    }

	this.getClases = function(){
		return this.diasConClase;
	}

	this.getClaseAUnaHora = function(key){
		tiene = false;
		if(this.diasConClase.hasOwnProperty(key)){
			tiene = true;
		}
		return tiene;
	}



}

module.exports = Profesor;