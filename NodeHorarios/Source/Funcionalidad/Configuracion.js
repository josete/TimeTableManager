var horario = require("../Objetos/Horario.js");

var Configuracion = function () {

    this.vacia = true;
    this.sesiones = [];
    this.profesores = [];
    this.asignaturas = [];
    this.cursos = [];
    this.horarios = [];
    this.horariosValidos = [];

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

    this.getHorariosDeUnGrupo = function(nombre){
        horariosGrupo = [];
        for(i=0;i<this.horarios.length;i++){
            if(this.horarios[i].grupo.nombre==nombre){
                horariosGrupo.push(this.horarios[i]);
            }
        }
        return horariosGrupo;
    }

    this.getSesionesPorNombreCurso = function (curso) {
        sesionesCurso = [];
        for (i = 0; i < this.sesiones.length; i++) {
            if ((this.sesiones[i].curso.getNombre()+" "+this.sesiones[i].curso.getCurso() == curso)) {
                sesionesCurso.push(this.sesiones[i]);
            }
        }
        return sesionesCurso;
    }

    this.anadirProfesor = function (profesor) {
        this.profesores.push(profesor);
    }

    this.anadirAsignatura = function (asignatura) {
        this.asignaturas.push(asignatura);
    }

    this.getAsignaturaPorNombre = function (nombre) {
        for (i = 0; i < this.asignaturas.length; i++) {
            if (this.asignaturas[i].getNombre() == nombre) {
                return this.asignaturas[i];
            }
        }
    }

    this.getProfesorPorNombre = function (nombre) {
        for (i = 0; i < this.profesores.length; i++) {
            if (this.profesores[i].getNombre() == nombre) {
                return this.profesores[i];
            }
        }
    }

    this.anadirCurso = function (curso) {
        this.cursos.push(curso);
    }

    this.getCursoPorNombre = function (nombre) {
        for (i = 0; i < this.cursos.length; i++) {
            if (this.cursos[i].getNombre() + " " + this.cursos[i].getCurso() == nombre) {
                return this.cursos[i];
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
                    if (ho.horarioGenerado["Dias"] > dias) { dias = ho.horarioGenerado["Dias"] }
                    try {
                        if (ho.horarioGenerado[j + "-" + k].getAsignatura().getProfesor().getNombre() == profesor) {
                            h.anadirClaseAHorario(j + "-" + k, ho.horarioGenerado[j + "-" + k]);
                        }
                    } catch (err) { }
                }
            }
        }
        h.horarioGenerado["Dias"] = dias;
        return h;
    }

    this.aceptarHorario = function(grupo){
        posicion = 0;
        calidad = 0;
        horariosObtenidos = this.getHorariosDeUnGrupo(grupo);
        for(i=0;i<horariosObtenidos.length;i++){
            if(horariosObtenidos[i].valor>calidad){
                posicion=i;
                calidad = horariosObtenidos[i].valor;
            }
        }
        //El horario se acepta para hacer definitivas las horas del profesor
        horariosObtenidos[posicion].aceptar();
        console.log("El valor es: "+calidad);
        horariosObtenidos[posicion].imprimir();
        //Se añade el horario al array de horario aceptados
        this.horariosValidos.push(horariosObtenidos[posicion]);
    }

}

module.exports = Configuracion;