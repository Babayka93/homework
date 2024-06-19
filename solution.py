from collections import deque

class Market:
    def __init__(self):
        self.queue = deque()
        self.orders = []

    def enqueue(self, person):
        self.queue.append(person)
        print(f"{person} добавлен в очередь")

    def dequeue(self):
        if self.queue:
            person = self.queue.popleft()
            print(f"{person} удален из очереди")
            return person
        else:
            print("Очередь пуста")

    def accept_order(self, order):
        self.orders.append(order)
        print(f"Принят заказ: {order}")

    def deliver_order(self):
        if self.orders:
            order = self.orders.pop(0)
            print(f"Заказ {order} выдан")
            return order
        else:
            print("Нет заказов на выдачу")

    def update(self):
        if self.orders:
            order = self.deliver_order()
            print(f"Выдан заказ: {order}")
        else:
            print("Нет заказов для выдачи")