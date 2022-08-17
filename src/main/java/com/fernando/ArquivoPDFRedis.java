package com.fernando;

import java.io.Serializable;
import java.util.List;

public class ArquivoPDFRedis implements Serializable {
    private Integer totalPaginas;
    private List<String> paginas;

    public ArquivoPDFRedis(Integer totalPaginas, List<String> paginas) {
        this.totalPaginas = totalPaginas;
        this.paginas = paginas;
    }

    public ArquivoPDFRedis() {
    }

    public Integer getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(Integer totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public List<String> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<String> paginas) {
        this.paginas = paginas;
    }
}
