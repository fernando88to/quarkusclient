package com.fernando;

import java.io.Serializable;
import java.util.List;

public class ArquivoPDFRedis implements Serializable {
    public Integer totalPaginas;
    public List<String> paginas;

    public ArquivoPDFRedis(Integer totalPaginas, List<String> paginas) {
        this.totalPaginas = totalPaginas;
        this.paginas = paginas;
    }

    public ArquivoPDFRedis() {
    }
}
