 //Tell the TypeScript compiler that importing .vue files is OK
 declare module "*.vue" {
  import { defineComponent } from "vue";
  const component: ReturnType<typeof defineComponent>;
  export default component;
}