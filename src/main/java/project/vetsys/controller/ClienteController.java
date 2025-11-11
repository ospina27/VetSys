/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.controller;

import java.util.List;
import project.vetsys.dao.ClienteDAO;
import project.vetsys.model.ClienteModel;

/**
 *
 * @author Asus
 */
public class ClienteController {

    
    private ClienteDAO clienteDAO = new ClienteDAO();

    public boolean guardarCliente(ClienteModel cliente) {
        return clienteDAO.insertarCliente(cliente);
    }

    public List<ClienteModel> obtenerClientes(int idClinica) {
        return clienteDAO.listarClientes(idClinica);
    }

    public boolean modificarCliente(ClienteModel client) {
        return clienteDAO.actualizarCliente(client);
    }

    public boolean eliminarCliente(int idCliente) {
        return clienteDAO.eliminarCliente(idCliente);
    }
    
    
    
}
