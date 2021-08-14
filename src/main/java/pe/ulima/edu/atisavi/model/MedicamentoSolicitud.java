package pe.ulima.edu.atisavi.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;  
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name =  "medicamentoSolicitud")
public class MedicamentoSolicitud {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)  
	private Medicamento medicine;  	
	
	private LocalDateTime pickDate;  
	@OneToMany(mappedBy = "medicamentoSoli", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Receta> pages;
	
	private Integer quantity;

}
