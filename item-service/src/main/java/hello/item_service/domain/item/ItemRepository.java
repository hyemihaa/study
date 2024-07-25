package hello.item_service.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // Item 저장소
public class ItemRepository {
    // map(key, value) :  키와 값을 하나의 쌍으로 저장하는 방식
    private static final Map<Long, Item> store = new HashMap<>(); //static 사용
    private static long sequence = 0L; //static 사용

    // Item을 저장하는 기능
    public Item save(Item item) {
        item.setId(++sequence);
        // put(K key, V value) 키와 값을 맵에 저장 한다.
        store.put(item.getId(), item);
        return item;
    }

    // 하나 조회
    public Item findById(Long id) {
        // get(Object key) 지정된 키에 대응하는 값을 반환
        return store.get(id);
    }

    // 전체 조회
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    // 업데이트
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear(); // HashMap에 저장해놓은 데이터 다 제거 (test후 사용하려고 생성)
    }

}
