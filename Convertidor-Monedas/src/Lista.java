import java.util.ArrayList;

public class Lista {

    private ArrayList<TipoDeCambio> listaConverciones;

    public Lista(){
        this.listaConverciones = new ArrayList<>();
    }

    public void agregarRegistro(TipoDeCambio registro){
        if (registro != null && registro.getMonedaBase() != null && registro.getMonedaDestino() != null) {
            listaConverciones.add(registro);
        }
    }

    public void mostrarLista(){
        for (TipoDeCambio listaConverticione : listaConverciones) {
            System.out.println(" Codigo Base: " + listaConverticione.getMonedaBase() + " |\tCodigo Destino "+listaConverticione.getMonedaDestino() + "\t Cantidad " + listaConverticione.getTotalConvertir() + " |\tValor final "+ listaConverticione.getTotalConvertido());
        }
    }

    @Override
    public String toString() {
        return "Lista{" + "listaConverciones=" + listaConverciones + '}';
    }
}




