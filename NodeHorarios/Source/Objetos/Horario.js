var comprobaciones = require("../Funcionalidad/Comprobaciones.js");

var Horario = function () {

	this.grupo = null;
	this.sesiones = null;
	this.horaInicio = 8;
	this.horasDia = 6;
	this.horarioGenerado = {};
	this.generado = false;

	//Evaluacion del horario
	this.valor = 0;

	this.comprobar = new comprobaciones();

	this.generar = function () {
		if (this.grupo == null || this.sesiones == null) {
			throw new Error("El horario no tiene grupo o sesiones");
		} else {
			horasTotalesDia = this.horasDia;
			actual = this.getRandomInt(this.sesiones.length);
			dia = 0;
			horaActual = this.horaInicio;
			intento = 0;//Pruebas
			while (this.sesiones.length > 0 && dia<5) {
				intento++;
				profesor = this.sesiones[actual].getAsignatura().getProfesor();
				asignatura = this.sesiones[actual].getAsignatura();
				sesion = this.sesiones[actual];				
				//if (asignatura.diaActualPuede() && this.comprobar.comprobarSolape(profesor, dia + "-" + horaActual)
					//&& this.comprobar.comprobarHorasDiarias(profesor, sesion,dia)) {
					this.horarioGenerado[dia + "-" + horaActual] = sesion;
					//profesor.anadirClase(dia + "-" + horaActual, sesion);
					horasTotalesDia -= sesion.getHoras();
					horaActual += parseInt("10",sesion.getHoras());
					//asignatura.setPuede(false);
					this.sesiones.splice(actual, 1);
					intento = 0;
				//}
				actual=this.getRandomInt(this.sesiones.length);
				if (horasTotalesDia <= 0 || intento > 3) {
					horasTotalesDia = this.horasDia;
					dia++;
					horaActual = this.horaInicio;
					//this.resetear();
				}
				/*if (actual >= this.sesiones.length) {
					actual = 0;
				}*/
			}
			this.horarioGenerado["Dias"] = dia;
			this.generado = true;
		}
	}

	this.setGrupo = function (grupo) {
		this.grupo = grupo;
	}

	this.setSesiones = function (sesiones) {
		this.sesiones = sesiones;
	}

	this.getSesiones = function () {
		return this.sesiones;
	}

	this.imprimir = function () {
		try {
			process.stdout.write("Horario Grupo:" + this.grupo.getNombre() + " " + this.grupo.getCurso().getCurso() + "\n");
		} catch (err) { }
		for (i = this.horaInicio; i < (this.horaInicio + this.horasDia); i += 2) {
			for (j = 0; j < (this.horarioGenerado["Dias"] + 1); j++) {
				try {
					process.stdout.write(this.horarioGenerado[j + "-" + i].getAsignatura().getNombre());
					process.stdout.write("	");
				} catch (err) {process.stdout.write("---");process.stdout.write("	"); }
			}
			process.stdout.write("\n");
		}
		process.stdout.write("---------------------------\n");
	}

	this.resetear = function () {
		for (i = 0; i < this.sesiones.length; i++) {
			this.sesiones[i].getAsignatura().setPuede(true);
		}
	}

	this.anadirClaseAHorario = function (key, sesion) {
		this.horarioGenerado[key] = sesion;
	}

	this.getGenerado = function () {
		return this.generado;
	}

	this.getRandomInt = function(max) {
    	return Math.floor(Math.random() * ((max-1) - 0 + 1)) + 0;
	}

	this.aceptar=function(){
		horarioIntermedio = this.horarioGenerado;
		Object.keys(this.horarioGenerado).forEach(function(element){
			try{
				horarioIntermedio[element].asignatura.profesor.anadirClase(element,horarioIntermedio[element]);
			}catch(err){}
		});
	}
}

module.exports = Horario;