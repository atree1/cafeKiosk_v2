package org.zerock.web;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;

/**
 * Servlet implementation class UploadEx1
 */
@WebServlet("/upload1")
@MultipartConfig(maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class UploadEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadEx1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Collection<Part> parts = request.getParts();

		parts.stream().filter(part -> part.getContentType() != null).forEach(part -> {
			System.out.println(part.getContentType());
			System.out.println(part.getSubmittedFileName());
			System.out.println("---------------------------");

			String uploadName = UUID.randomUUID() + "_" + part.getSubmittedFileName();

			try {
				InputStream in = part.getInputStream();
				FileOutputStream fos = new FileOutputStream("C:\\zzz\\upload\\" + uploadName);

				IOUtils.copy(in, fos);
				
				if(ExtChecker.check(uploadName)) {
				// Make Thumbnail image
				BufferedImage bImage = ImageIO.read(new FileInputStream("C:\\zzz\\upload\\" + uploadName));
				BufferedImage thumbnail = Scalr.resize(bImage, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, 150, 100,
						Scalr.OP_ANTIALIAS);
				
				FileOutputStream thfos = new FileOutputStream("C:\\zzz\\upload\\s_" + uploadName);
				ImageIO.write(thumbnail, "jpg", thfos);
				thfos.close();
				}
				in.close();
				fos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		});

	}

}