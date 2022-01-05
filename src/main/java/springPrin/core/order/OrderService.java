package springPrin.core.order;

public interface OrderService {
    // return 으로 주문결과를 반환하는 부분
    Order createOrder(Long memberId, String itemName,int itemPrice);

}
