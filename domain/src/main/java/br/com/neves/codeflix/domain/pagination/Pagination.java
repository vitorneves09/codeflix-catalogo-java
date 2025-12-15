package br.com.neves.codeflix.domain.pagination;

import java.util.List;

public record Pagination<T>(
                            int currnetPagge,
                            int perPage,
                            long total,
                            List<T> items) {


}
