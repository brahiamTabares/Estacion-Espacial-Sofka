package sofka.estacionEspacial.cliente;

import javax.swing.*;

public class MenuNaves {

    public  void menuNaves( int opc){

        do {
            JOptionPane.showMessageDialog(null,"Bienvenido la estacion espacial ");
            JOptionPane.showMessageDialog(null,"seleccione la opcion deseada");

            opc=Integer.parseInt(JOptionPane.showInputDialog("1-Crear Nave\n " + "2-Actualizar Nave\n"
                    +"3-eliminar Nave\n"+"4-buscar Nave\n"+"5-salir"));

           switch (opc){
               case 1:
                   break;
               case 2:
                   break;
               case 3:
                   break;

               case 4:
                   break;
           }

        }while (opc!=5);
    }
    public void opcionesNave(int opc2){

        do {
            JOptionPane.showMessageDialog(null,"Seleccione el tipo de nave\n ");

            opc2=Integer.parseInt(JOptionPane.showInputDialog("1-Lanzadera\n " + "2-Tripulada\n"
                    +"3 no Tripulada\n"+"4-salir"));
            switch (opc2){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;

                case 4:
                    break;
            }

        }while (opc2!=5);
    }

}
