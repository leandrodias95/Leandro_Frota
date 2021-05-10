package br.com.Leandro_Frota.dao;

import br.com.Leandro_Frota.model.Veiculo;
import br.com.Leandro_Frota.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO implements GenericDAO {

    private Connection conexao;
    
    public VeiculoDAO() throws Exception{
        conexao= SingleConnection.getConnection();
    }
    
    @Override
    public Boolean cadastrar(Object objeto) {
       Veiculo oVeiculo = (Veiculo) objeto;
        Boolean retorno = false;
        if (oVeiculo.getIdVeiculo() == 0) {
            retorno = this.inserir(oVeiculo);
        } else {
            retorno = this.alterar(oVeiculo);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into Veiculo (marca, modelo, odometro, valorVeiculo, observacao) values (?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oVeiculo.getMarca());
            stmt.setString(2, oVeiculo.getModelo());
            stmt.setInt(3, oVeiculo.getOdometro());
            stmt.setDouble(4, oVeiculo.getValorVeiculo());
            stmt.setString(5, oVeiculo.getObservacao());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar o Veiculo! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro:" + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        PreparedStatement stmt = null;
        String sql = "update Veiculo set marca=?, modelo=?, odometro=?, valorVeiculo=?, observacao=? where idVeiculo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oVeiculo.getMarca());
            stmt.setString(2, oVeiculo.getModelo());
            stmt.setInt(3, oVeiculo.getOdometro());
            stmt.setDouble(4, oVeiculo.getValorVeiculo());
            stmt.setString(5, oVeiculo.getObservacao());
            stmt.setInt(6, oVeiculo.getIdVeiculo());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar o Veiculo! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro:" + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idVeiculo = numero;
        PreparedStatement stmt = null;

        String sql = "delete from Veiculo where idVeiculo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idVeiculo);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o Veiculo! Erro: "
                    + ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rolback " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }
    
    @Override
    public Object carregar(int numero) {
        int idVeiculo = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Veiculo oVeiculo = null;
        String sql = "select * from Veiculo where idVeiculo=?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idVeiculo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oVeiculo = new Veiculo();
                oVeiculo.setIdVeiculo(rs.getInt("IdVeiculo"));
                oVeiculo.setMarca(rs.getString("marca"));
                oVeiculo.setModelo(rs.getString("modelo"));
                oVeiculo.setOdometro(rs.getInt("odometro"));
                oVeiculo.setValorVeiculo(rs.getDouble("valorVeiculo"));
                oVeiculo.setObservacao(rs.getString("observacao"));
            }
            return oVeiculo;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Veiculo! Erro:" + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs= null;
        String sql= "Select * from Veiculo order by idVeiculo";
        try{
            stmt = conexao.prepareStatement(sql);
            rs=stmt.executeQuery();
            while (rs.next()){
                Veiculo oVeiculo = new Veiculo();
                oVeiculo.setIdVeiculo(rs.getInt("IdVeiculo"));
                oVeiculo.setMarca(rs.getString("marca"));
                oVeiculo.setModelo(rs.getString("modelo"));
                oVeiculo.setOdometro(rs.getInt("odometro"));
                oVeiculo.setValorVeiculo(rs.getDouble("valorVeiculo"));
                oVeiculo.setObservacao(rs.getString("observacao"));
                resultado.add(oVeiculo);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao listar os Veiculos! Erro: "+ex.getMessage());
        }
        return resultado;
    }
    
}
