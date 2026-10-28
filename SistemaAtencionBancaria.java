package com.mycompany.sistemaatencionbancaria;

import javax.swing.JOptionPane;

public class SistemaAtencionBancaria {

    public static void main(String[] args) {
        SistemaAtencionBancaria m1 = new SistemaAtencionBancaria();
        Turno p = new Turno("1", "leosbel", "ext", 16);
        Turno p1 = new Turno("2", "eduardo", "dep", 16);
        Turno p2 = new Turno("3", "jose", "ext", 16);
        Turno p3 = new Turno("4", "dan", "com", 16);
        Turno p4 = new Turno("5", "yoel", "com", 16);
        DoubleLinkedList<Turno> l1 = new DoubleLinkedList<>();
        l1.add(p);
        l1.add(p1);
        l1.add(p2);
        l1.add(p3);
        l1.add(p4);
        l1.add(p, 20);
        System.out.println(l1.remove(5).getNombrecliente());

        String oper = "";
        while (!oper.equals("2")) {
            System.out.println("1-Atender siguiente.");
            System.out.println("2-Salir");
            oper = JOptionPane.showInputDialog("Entre una opcion");
            switch (oper) {
                case "1":
                    try {
                        Turno t = m1.atenderSiguienteTurno(l1);
                        System.out.println("Atendiendo turno: " + t.getNombrecliente());
                    } catch (IllegalStateException e) {
                        System.out.println("No hay mas turnos: " + e.getMessage());
                    }
                    break;
                case "2":
                    break;
                default:
                    System.out.println("La opcion no es valida");

            }
        }

    }

    public Turno atenderSiguienteTurno(DoubleLinkedList<Turno> l1) {
        if (l1 == null || l1.isEmpty()) {
            throw new IllegalStateException("No hay turnos pendientes");
        }
        Turno aux = l1.first.getInfo();
        l1.first = l1.first.getNext();
        if (l1.first != null) {
            l1.first.setPrev(null);
        }
        l1.size--;
        return aux;
    }
}
