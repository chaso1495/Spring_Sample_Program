package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 컴포넌트 스캔 대상으로 지정
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //static 사용, 실무에서는 Hash 말고 ConcurrentHash
    private static long sequence = 0L; // static 사용

    public Item save(Item item) { // 저장
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) { // 회원 조회
        return store.get(id);
    }

    public List<Item> findAll() { // 전체 조회
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) { // 수정
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() { // 초기화
        store.clear();
    }
}