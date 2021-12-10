public class Maestria extends Student{
    Maestria(String nombre) {
        super(nombre);
    }
    int Grado(){
        return this._notaBase + 1;
    }
}
