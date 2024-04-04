// package br.com.gerenciaprotocolo.model;

// import java.time.LocalDate;
// import jakarta.persistence.*;


// @Entity
// @Table(name = "Protocolo")
// public class Protocolo {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long protocoloNumero;

//     @Column(name = "Data_Abertura", nullable = false)
//     private LocalDate dataAbertura;

//     @Column(name = "Tipo_Protocolo", nullable = false)
//     private String tipoProtocolo;

//     @Column(name = "Descricao", nullable = false)
//     private String descricao;

//     @Column(name = "Data_Prazo", nullable = false)
//     private LocalDate dataPrazo;

//     @Column(name = "Data_UltimaAcao")
//     private LocalDate dataUltimaAcao;

//     @Column(name = "Data_Recebimento")
//     private LocalDate dataRecebimento;

//     @Column(name = "PropensaoBacen")
//     private Boolean propensaoBacen;

//     @Column(name = "Agilizar")
//     private Boolean agilizar;

//     @Column(name = "Devido")
//     private Boolean devido;

//     @Column(name = "Procedente")
//     private Boolean procedente;

//     @ManyToOne
//     @JoinColumn(name = "Cliente_ID", nullable = false)
//     private Cliente cliente;

//     @ManyToOne
//     @JoinColumn(name = "Canal_ID", nullable = false)
//     private Canal canal;

//     @ManyToOne
//     @JoinColumn(name = "Departamento_ID", nullable = false)
//     private Departamento departamento;


//   public Long getProtocoloNumero() {
//     return this.protocoloNumero;
//   }

//   public void setProtocoloNumero(Long protocoloNumero) {
//     this.protocoloNumero = protocoloNumero;
//   }

//   public LocalDate getDataAbertura() {
//     return this.dataAbertura;
//   }

//   public void setDataAbertura(LocalDate dataAbertura) {
//     this.dataAbertura = dataAbertura;
//   }

//   public String getTipoProtocolo() {
//     return this.tipoProtocolo;
//   }

//   public void setTipoProtocolo(String tipoProtocolo) {
//     this.tipoProtocolo = tipoProtocolo;
//   }

//   public String getDescricao() {
//     return this.descricao;
//   }

//   public void setDescricao(String descricao) {
//     this.descricao = descricao;
//   }

//   public LocalDate getDataPrazo() {
//     return this.dataPrazo;
//   }

//   public void setDataPrazo(LocalDate dataPrazo) {
//     this.dataPrazo = dataPrazo;
//   }

//   public LocalDate getDataUltimaAcao() {
//     return this.dataUltimaAcao;
//   }

//   public void setDataUltimaAcao(LocalDate dataUltimaAcao) {
//     this.dataUltimaAcao = dataUltimaAcao;
//   }

//   public LocalDate getDataRecebimento() {
//     return this.dataRecebimento;
//   }

//   public void setDataRecebimento(LocalDate dataRecebimento) {
//     this.dataRecebimento = dataRecebimento;
//   }

//   public Boolean isPropensaoBacen() {
//     return this.propensaoBacen;
//   }

//   public Boolean getPropensaoBacen() {
//     return this.propensaoBacen;
//   }

//   public void setPropensaoBacen(Boolean propensaoBacen) {
//     this.propensaoBacen = propensaoBacen;
//   }

//   public Boolean isAgilizar() {
//     return this.agilizar;
//   }

//   public Boolean getAgilizar() {
//     return this.agilizar;
//   }

//   public void setAgilizar(Boolean agilizar) {
//     this.agilizar = agilizar;
//   }

//   public Boolean isDevido() {
//     return this.devido;
//   }

//   public Boolean getDevido() {
//     return this.devido;
//   }

//   public void setDevido(Boolean devido) {
//     this.devido = devido;
//   }

//   public Boolean isProcedente() {
//     return this.procedente;
//   }

//   public Boolean getProcedente() {
//     return this.procedente;
//   }

//   public void setProcedente(Boolean procedente) {
//     this.procedente = procedente;
//   }

//   public Cliente getCliente() {
//     return this.cliente;
//   }

//   public void setCliente(Cliente cliente) {
//     this.cliente = cliente;
//   }

//   public Canal getCanal() {
//     return this.canal;
//   }

//   public void setCanal(Canal canal) {
//     this.canal = canal;
//   }

//   public Departamento getDepartamento() {
//     return this.departamento;
//   }

//   public void setDepartamento(Departamento departamento) {
//     this.departamento = departamento;
//   }
    
// }