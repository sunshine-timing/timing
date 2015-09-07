package com.study.lucene.simple;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer
{
	public static void main(String[] args) throws Exception
	{
		/*
		 * 入参判断
		 * 
		 * if (args.length != 2) { throw new IllegalArgumentException(
		 * "Usage:java " + Indexer.class.getName() + " <index dir> <data dir>");
		 * }
		 * 
		 * // 解析参数 String indexDir = args[0];// 指定目录创建索引 String dataDir =
		 * args[1]; // 对指定目录的txt文件进行索引
		 */
		String indexDir = "d:\\lucene";
		String dataDir = "d:\\bk";

		long start = System.currentTimeMillis();
		Indexer indexer = new Indexer(indexDir);
		int numIndexed;
		try
		{
			numIndexed = indexer.index(dataDir, null);
		} finally
		{
			indexer.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("Indexing " + numIndexed + " files took " + (end - start) + " milliseconds");

	}

	private IndexWriter writer;

	/**
	 * 创建Lunece Index Writer
	 * 
	 * @param indexDir
	 * @throws IOException
	 */
	public Indexer(String indexDir) throws IOException
	{
		Directory dir = FSDirectory.open(new File(indexDir).toPath());
		writer = new IndexWriter(dir, new IndexWriterConfig(new StandardAnalyzer()));

	}

	/**
	 * 关闭IndexWriter
	 */
	public void close() throws IOException
	{
		writer.close();
	}

	public int index(String dataDir, FileFilter fileFilter) throws Exception
	{
		File[] files = new File(dataDir).listFiles();
		for (File file : files)
		{
			if (!file.isDirectory() && !file.isHidden() && file.exists() && file.canRead() && (fileFilter == null || fileFilter.accept(file)))
			{
				indexFile(file);
			}
		}
		return writer.numDocs();// 返回被索引文档数
	}

	/**
	 * 添加索引信息
	 * 
	 * @param f
	 * @return
	 * @throws Exception
	 */
	protected Document getDocument(File f) throws Exception
	{
		Document doc = new Document();
		doc.add(new Field("content", new FileReader(f)));// 索引文件内容
		doc.add(new Field("Filename", f.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));// 索引文件名
		doc.add(new Field("fullpath", f.getCanonicalPath(), Field.Store.YES, Field.Index.NOT_ANALYZED));// 索引文件完整路径
		return doc;
	}

	/*
	 * 向lunece索引中添加文档
	 */
	private void indexFile(File f) throws Exception
	{
		System.out.println("Indexing " + f.getCanonicalPath());
		Document doc = getDocument(f);
		writer.addDocument(doc);
	}
}
