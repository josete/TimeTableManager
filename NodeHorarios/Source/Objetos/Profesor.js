var Profesor = function (nombre, minHorasDia, maxHorasDia) {
	if (nombre == null) {
		throw Error("Profesor sin nombre");
	}
	if (maxHorasDia == 0) {
		throw Error("Profesor sin horas");
	}
	this.nombre = nombre;
	this.diasConClase = {};
	this.minHorasDia = minHorasDia;
	this.maxHorasDia = maxHorasDia;
	
	this.horasDias = [];
	

	this.getNombre = function () {
		return this.nombre;
	}

	this.anadirClase = function (key, sesion) {
		this.diasConClase[key] = sesion.getAsignatura();
		d = key.split("-")[0];
		if(this.horasDias[parseInt(d)] != undefined){
			this.horasDias[parseInt(d)]+=sesion.getHoras();
		}else{
			this.horasDias[parseInt(d)]=sesion.getHoras();
		}
	}

	this.getClases = function () {
		return this.diasConClase;
	}

}

module.exports = Profesor;