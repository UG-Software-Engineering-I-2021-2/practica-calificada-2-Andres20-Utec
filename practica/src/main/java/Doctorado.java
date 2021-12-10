
public class Doctorado extends Student{
    Doctorado( String nombre) {
        super(nombre);
    }
    int Grado(){
        return this._notaBase + 2;
    }
}
