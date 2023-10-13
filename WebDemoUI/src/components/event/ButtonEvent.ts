// ButtonEvent.ts
import { ref } from 'vue';

export default function useButtonEvent(emit: (event: string, ...args: any[]) => void) {
  const contenRecv = ref<number>(0);

  const showDialog = () => {
    contenRecv.value++;
    emit('showDialog1', contenRecv.value);
  };

  return { showDialog };
}
