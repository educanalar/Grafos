public class Vertice {
    // Nombre de la persona. Puede ser de otro tipo tal como Persona, Estudiante, etc.
    String nombre;

    // Constructor
    Vertice(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        // Compara a través de la propiedad nombre, puede ser cualquier otra, como CURP, NoControl, etc.
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vertice other = (Vertice) obj;
        // Compara a través de la propiedad nombre
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        return true;
    }

}

