package com.umprogramax.lojaStock.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "venda")
@Entity(name = "venda")
@EqualsAndHashCode(of = "id")
public class Venda {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataDaVenda;

    public String getDataDaVenda(String dataDaVenda) {
        return dataDaVenda;
    }

    public void setDataDaVenda(LocalDateTime dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

}
