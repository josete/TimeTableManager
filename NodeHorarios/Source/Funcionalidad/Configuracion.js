var horario = require("../Objetos/Horario.js");

var Configuracion = function () {

    this.vacia = true;
    this.sesiones = [];
    this.profesores = [];
    this.horarios = [];

    this.isVacia = function () {
        return this.vacia;
    }

    this.anadirSesion = function (sesion) {
        this.sesiones.push(sesion);
    }

    this.getSesiones = function () {
        return this.sesiones;
    }

    this.anadirHorario = function (horario) {
        this.horarios.push(horario);
    }

    this.getHorarios = function () {
        return this.horarios;
    }

    this.getSesionesPorCurso = function (curso) {
        sesionesCurso = [];
        for (i = 0; i < this.sesiones.length; i++) {
            if (this.sesiones[i].getCurso() == curso) {
                sesionesCurso.push(this.sesiones[i]);
            }
        }
        return sesionesCurso;
    }

    this.anadirProfesor = function(profesor){
        this.profesores.push(profesor);
    }

    this.getProfesorPorNombre = function(nombre){
        for(i=0;i<this.profesores.length;i++){
            if(this.profesores[i].getNombre()==nombre){
                return this.profesores[i];
            }
        }
    }

    this.getHorarioProfesor = function (profesor) {
        h = new horario();
        dias = 0;
        for (i = 0; i < this.horarios.length; i++) {
            ho = this.horarios[i];
            for (k = ho.horaInicio; k < (ho.horaInicio + ho.horasDia); k += 2) {
                for (j = 0; j < (ho.horarioGenerado["Dias"] + 1); j++) {
                    if(ho.horarioGenerado["Dias"]>dias){dias = ho.horarioGenerado["Dias"]}
                    try {
                      if(ho.horarioGenerado[j + "-" + k].getAsignatura().getProfesor().getNombre()==profesor){
                          h.anadirClaseAHorario(j + "-" + k,ho.horarioGenerado[j + "-" + k]);
                      }
                    } catch (err) { }
                }
            }
        }
        h.horarioGenerado["Dias"] = dias;
        return h;
    }

}

module.exports = Configuracion;