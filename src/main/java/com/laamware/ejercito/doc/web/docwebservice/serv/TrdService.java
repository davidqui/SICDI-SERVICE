/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.dto.TrdDTO;
import com.laamware.ejercito.doc.web.docwebservice.entity.Trd;
import com.laamware.ejercito.doc.web.docwebservice.repo.TrdRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author sdelgadom
 */
@Service
public class TrdService {
    
    @Autowired
    private TrdRepository trdRepository;
    
    
    public List<TrdDTO> trds() {
        return trdsHierarchy();
    }
    
    public List<TrdDTO> trdsHierarchy(){
        List<Trd> root = trdRepository.findByActivoAndSerieNull(Boolean.TRUE,
                new Sort(Sort.Direction.ASC, "nombre"));
        List<TrdDTO> listTrd = new ArrayList<>();
        for (Trd trd : root) {
            TrdDTO tr = new TrdDTO(trd.getId(), trd.getNombre(), trd.getCodigo(), new ArrayList<TrdDTO>());
            trdsHierarchy(tr);
            listTrd.add(tr);
        }
        return listTrd;
    }
    
    public void trdsHierarchy(TrdDTO t){
        List<Trd> subs = trdRepository.findBySerieAndActivoTrue(t.getId(),
                new Sort(Sort.Direction.ASC, "nombre"));
        for (Trd sub : subs) {
            TrdDTO tr = new TrdDTO(sub.getId(), sub.getNombre(), sub.getCodigo(), new ArrayList<TrdDTO>());
            trdsHierarchy(tr);
            t.getSubTrds().add(tr);
        }
    }
}
