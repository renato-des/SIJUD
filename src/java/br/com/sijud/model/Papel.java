/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.model;

/**
 *
 * @author renat_dvxxuhs
 */

public enum Papel {
        ADM(0), GERENTE(1), USUARIO_SIMPLES(2);

        private final int valorPapel;

        Papel(int valorPapel) {
            this.valorPapel = valorPapel;
        }

        public int getValorPapel() {
            return valorPapel;
        }
    }