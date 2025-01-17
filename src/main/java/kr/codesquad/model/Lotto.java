package kr.codesquad.model;

import java.util.List;

/**
 * 로또를 의미하는 객체
 */
public class Lotto {

    public static final int SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 로또에 보너스 보너스 번호가 포함되어 있는지 확인하는 메서드
     * @param lottoNumber 보너스 번호
     * @return 포함 여부
     */
    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    /**
     * 비교하는 로또와 몇개의 번호가 일치하는지 확인하는 메서드
     * @param compare 비교할 로또 번호
     * @return 일치하는 개수
     */
    public int countMatches(Lotto compare) {
        return (int) compare.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
