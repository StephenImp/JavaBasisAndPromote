package com.cn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by admin on 2018/4/16.
 */
public class DisplayProductInfoWithCompletionService {


    /**
     1.CompletionService接口定义了一组任务管理接口:
         submit() - 提交任务
         take() - 获取任务结果
         poll() - 获取任务结果

     2.ExecutorCompletionService类是CompletionService接口的实现
         ExecutorCompletionService内部管理者一个已完成任务的阻塞队列
         ExecutorCompletionService引用了一个Executor, 用来执行任务
         submit()方法最终会委托给内部的executor去执行任务
         take/poll方法的工作都委托给内部的已完成任务阻塞队列
         如果阻塞队列中有已完成的任务, take方法就返回任务的结果, 否则阻塞等待任务完成
         poll与take方法不同, poll有两个版本:
         无参的poll方法 --- 如果完成队列中有数据就返回, 否则返回null
         有参数的poll方法 --- 如果完成队列中有数据就直接返回, 否则等待指定的时间, 到时间后如果还是没有数据就返回null
         ExecutorCompletionService主要用与管理异步任务 (有结果的任务, 任务完成后要处理结果)
     */

    //线程池
    private final ExecutorService executorService;
    //日期格式器
    private final DateFormat format = new SimpleDateFormat("HH:mm:ss");

    public DisplayProductInfoWithCompletionService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void renderProductDetail() {

        final List<ProductInfo> productInfos = loadProductInfos();

        CompletionService<ProductImage> completionService = new ExecutorCompletionService<ProductImage>(executorService);

        //为每个图像的下载建立一个工作任务
        for (final ProductInfo info : productInfos) {
            completionService.submit(new Callable<ProductImage>() {
                @Override
                public ProductImage call() throws Exception {
                    return info.getImage();
                }
            });
        }

        //展示商品简介的信息
        renderProductText(productInfos);

        try {
            //显示商品图片
            for (int i = 0, n = productInfos.size(); i < n; i++){
                Future<ProductImage> imageFuture = completionService.take();
                ProductImage image = imageFuture.get();
                renderProductImage(image);
            }
        } catch (InterruptedException e) {
            // 如果显示图片发生中断异常则重新设置线程的中断状态
            // 这样做可以让wait中的线程唤醒
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            try {
                throw new Throwable(e.getCause());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

    }


    private void renderProductImage(ProductImage image) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " display products images! "
                + format.format(new Date()));
    }

    private void renderProductText(List<ProductInfo> productInfos) {
        for (ProductInfo info : productInfos) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " display products description! "
                + format.format(new Date()));
    }

    private List<ProductInfo> loadProductInfos() {
        List<ProductInfo> list = new ArrayList<>();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ProductInfo info = new ProductInfo();
        info.setImage(new ProductImage());
        list.add(info);
        System.out.println(Thread.currentThread().getName() + " load products info! "
                + format.format(new Date()));
        return list;
    }

    /**
     * 商品
     */
    private static class ProductInfo {
        private ProductImage image;

        public ProductImage getImage() {
            return image;
        }

        public void setImage(ProductImage image) {
            this.image = image;
        }
    }

    private static class ProductImage {
    }

    public static void main(String[] args) {
        DisplayProductInfoWithCompletionService cd = new DisplayProductInfoWithCompletionService(Executors.newCachedThreadPool());
        cd.renderProductDetail();
    }

    /**
     * CompletionService小结
         相比ExecutorService，CompletionService可以更精确和简便地完成异步任务的执行
         CompletionService的一个实现是ExecutorCompletionService，它是Executor和BlockingQueue功能的融合体，
         Executor完成计算任务，BlockingQueue负责保存异步任务的执行结果

         在执行大量相互独立和同构的任务时，可以使用CompletionService
         CompletionService可以为任务的执行设置时限，主要是通过BlockingQueue的poll(long time,TimeUnit unit)为任务执行结果的取得限制时间，如果没有完成就取消任务
     */
}
