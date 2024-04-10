<template>
    <div class="outer">
        <div class="inner">
            <TTable class="table-auto">
                <caption class="caption-top text-right float-right">
                    Displaying 1 to 2 of 3 items
                </caption>
                <TThead>
                    <TTrr>
                        <TTh colspan="2" class="headcol bg-green-300">Header1</TTh>
                        <TTh colspan="2">Header2</TTh>
                        <TTh class="bg-rose-500" colspan="1" rowspan="2">Header3</TTh>
                    </TTrr>
                    <TTrr>
                        <TTh class="bg-lime-600 hard_left">AA</TTh>
                        <TTh class="bg-lime-600 next_left">ID</TTh>
                        <TTh class="bg-indigo-300" style="min-width: 200px;">Name</TTh>
                        <TTh class="bg-indigo-300">Code</TTh>

                    </TTrr>
                </TThead>
                <TTbody class="border-collapse">
                    <TTrr class="bg-gray-300/50">
                        <TTd class="hard_left"><input type="checkbox" class="w-4 h-4 text-blue-600"></input></TTd>
                        <TTd class="next_left">1</TTd>
                        <TTd>Malcolm Lockyer for ..............</TTd>
                        <TTd>🐦</TTd>
                        <TTd>cat@tvdatatable.test</TTd>
                    </TTrr>
                    <TTrr class="bg-gray-100/50">
                        <TTd class="hard_left"><input type="checkbox" class="w-4 h-4 text-blue-600"></input></TTd>
                        <TTd class="next_left">2</TTd>
                        <TTd>Malcolm Lockyer2</TTd>
                        <TTd>🐈</TTd>
                        <TTd>dog@tvdatatable.test</TTd>
                    </TTrr>
                    <TTrr class="bg-gray-300/50">
                        <TTd class="hard_left"><input type="checkbox" class="w-4 h-4 text-blue-600"></input></TTd>
                        <TTd class="next_left">3</TTd>
                        <TTd>Malcolm Lockyer3</TTd>
                        <TTd>🐕</TTd>
                        <TTd>bird@tvdatatable.test</TTd>
                    </TTrr>
                </TTbody>
                <tfoot class="tv-tfoot h-7">
                    <TTd class="hard_left bg-orange-600 h-12" colspan="1"> </TTd>
                    <TTd class="bg-green-300 next_left h-12"> </TTd>
                    <TTd colspan="3" class="bg-red-300 text-center">Footer</TTd>
                </tfoot>
            </TTable>
        </div>
    </div>
</template>
<script setup>
import { defineComponent } from 'vue';
import './TTableSample.css'
import TThead from './TThead.vue';
import TTbody from './TTbody.vue';
import TTrr from './TTrr.vue';
import TTd from './TTd.vue';
import TTh from './TTh.vue';

defineComponent({
    name: 'TableSample',
})

</script>